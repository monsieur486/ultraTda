let stompClient = null;
const ctx = document.getElementById('myChart');

function connect() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        document.getElementById('status').innerText = '🟢';
        stompClient.subscribe('/topic/state', function (message) {
            const state = JSON.parse(message.body);
            updateState(state);
        });
        stompClient.send("/app/state.get", {}, {});
    }, function (error) {
        document.getElementById('status').innerText = '🔴 ' + error;
    });
}

function updateState(state) {
    if(state.level === 100) recuperationData();
}

function recuperationData(){
    axios.get('/api/public/data')
        .then(response => {
            const data = response.data;
            afficheScores(data.scores);
            afficheGraph(data.graphInfo);
        })
        .catch(error => {
            console.error("Erreur lors de la récupération des information :", error);
            document.getElementById('error').innerHTML = "<p class='text-danger'>Impossible de charger les informations.</p>";
        });
}

function afficheScores(scores) {
    const scoresDiv = document.getElementById('scores');

    let html = `
                <table class="table table-striped">
                    <thead>
                        <tr>
                        </tr>
                    </thead>
                    <tbody>
            `;

    scores.forEach(s => {
        html += `
                    <tr>
                        <td class="align-middle">
                            <img src="/img/${s.imageUrl}" alt="${s.nom}" 
                                 style="width: 40px; height: 40px; border-radius: 50%; object-fit: cover;">
                            <span class="ms-3 fw-bold">${s.nom}</span>
                        </td>
                        <td class="align-middle text-end fw-bold" style="color: ${s.color};">
                            ${s.score}
                        </td>
                    </tr>
                `;
    });

    html += '</tbody></table>';
    scoresDiv.innerHTML = html;
}

function afficheGraph(datas) {
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: [0,1,2,3,4,5],
            datasets: [
                {
                    label: 'Toto',
                    data: [0, 19, 3, 5, 2, 3],
                    borderWidth: 5
                },
                {
                    label: 'Titi',
                    data: [0, -19, -3, -5, -2, -3],
                    borderWidth: 5
                },
                {
                    label: 'Tata',
                    data: [0, 10, 13, 15, 8, 13],
                    borderWidth: 5
                }
            ]
        },
        options: {
            animations: {
                tension: {
                    duration: 1500,
                    easing: 'linear',
                    from: 0.5,
                    to: 0,
                    loop: false
                }
            },
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

connect();
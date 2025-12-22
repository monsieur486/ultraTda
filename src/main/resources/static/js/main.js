let stompClient = null;

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
    if(state.level === 100) afficheScore();
}

function afficheScore(){
    axios.get('/api/public/scores')
        .then(response => {
            const scores = response.data;
            const scoresDiv = document.getElementById('scores');

            let html = `
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Joueur</th>
                            <th class="text-end">Score</th>
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
        })
        .catch(error => {
            console.error("Erreur lors de la récupération des scores :", error);
            document.getElementById('scores').innerHTML = "<p class='text-danger'>Impossible de charger les scores.</p>";
        });
}

connect();
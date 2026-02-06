const API = "http://localhost:8080/buses";
let allBuses = [];

function showPage(id) {
    document.querySelectorAll(".page").forEach(p => p.classList.add("hidden"));
    document.getElementById(id).classList.remove("hidden");
}

async function loadBuses() {
    const res = await fetch(API);
    allBuses = await res.json();
    renderTable(allBuses);
}

function renderTable(data) {
    const table = document.getElementById("busTable");
    table.innerHTML = "";

    data.forEach(bus => {
        table.innerHTML += `
        <tr>
            <td>${bus.routeNumber}</td>
            <td>${bus.capacity}</td>
            <td class="actions">
                <button onclick="deleteBus(${bus.routeNumber})">🗑</button>
            </td>
        </tr>`;
    });
}

function filterBuses() {
    const value = document.getElementById("searchInput").value;
    const filtered = allBuses.filter(b =>
        b.routeNumber.toString().includes(value)
    );
    renderTable(filtered);
}

async function addBus() {
    const route = document.getElementById("routeInput").value;
    const capacity = document.getElementById("capacityInput").value;

    const res = await fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ routeNumber: route, capacity: capacity })
    });

    document.getElementById("addStatus").innerText =
        res.ok ? "✅ Добавлено" : "❌ Ошибка";

    loadBuses();
}

async function deleteBus(route) {
    await fetch(`${API}/${route}`, { method: "DELETE" });
    loadBuses();    
}

loadBuses();

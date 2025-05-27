const events = [
  { id: 1, name: "Music Festival", category: "Music", seats: 5 },
  { id: 2, name: "Art Workshop", category: "Arts", seats: 3 },
  { id: 3, name: "Cooking Class", category: "Food", seats: 4 },
  { id: 4, name: "Jazz Night", category: "Music", seats: 2 },
  { id: 5, name: "Baking Workshop", category: "Food", seats: 1 },
];

const container = document.querySelector("#eventsContainer");
const categoryFilter = document.querySelector("#categoryFilter");
const searchInput = document.querySelector("#searchInput");

// Render events based on filters
function renderEvents() {
  // Get current filter values
  const selectedCategory = categoryFilter.value;
  const searchText = searchInput.value.toLowerCase();

  // Filter events by category and name search
  const filteredEvents = events.filter(event => {
    const matchCategory = selectedCategory === "all" || event.category === selectedCategory;
    const matchName = event.name.toLowerCase().includes(searchText);
    return matchCategory && matchName;
  });

  container.innerHTML = "";

  if(filteredEvents.length === 0) {
    container.textContent = "No events found.";
    return;
  }

  filteredEvents.forEach(event => {
    const card = document.createElement("div");
    card.className = "event-card";

    const info = document.createElement("div");
    info.innerHTML = `<strong>${event.name}</strong> — ${event.category} — Seats: ${event.seats}`;
    card.appendChild(info);

    const btn = document.createElement("button");
    btn.className = "register-btn";
    btn.textContent = "Register";
    btn.disabled = event.seats === 0;
    btn.onclick = () => {
      if(event.seats > 0) {
        event.seats--;
        alert(`Registered for ${event.name}`);
        renderEvents();  // Update UI after registration
      }
    };
    card.appendChild(btn);

    container.appendChild(card);
  });
}

// Event listeners for filters
categoryFilter.onchange = renderEvents;
searchInput.onkeydown = (e) => {
  // Delay rendering slightly to capture updated input value
  setTimeout(renderEvents, 100);
};

// Initial render
renderEvents();

// Sample events array
const events = [
  { id: 1, name: "Music Festival", seats: 5 },
  { id: 2, name: "Art Workshop", seats: 3 },
  { id: 3, name: "Cooking Class", seats: 0 }
];

const container = document.querySelector("#eventsContainer");

// Render all events dynamically
function renderEvents() {
  container.innerHTML = ""; // Clear previous content

  events.forEach(event => {
    // Create event card div
    const card = document.createElement("div");
    card.className = "event-card";

    // Event name and seats info
    const info = document.createElement("p");
    info.textContent = `${event.name} — Seats available: ${event.seats}`;
    card.appendChild(info);

    // Register button
    const registerBtn = document.createElement("button");
    registerBtn.textContent = "Register";
    registerBtn.className = "btn register-btn";
    registerBtn.disabled = event.seats === 0; // Disable if no seats
    registerBtn.addEventListener("click", () => {
      if(event.seats > 0) {
        event.seats--;
        updateUI(event.id);
        alert(`Registered for ${event.name}`);
      }
    });
    card.appendChild(registerBtn);

    // Cancel button
    const cancelBtn = document.createElement("button");
    cancelBtn.textContent = "Cancel Registration";
    cancelBtn.className = "btn cancel-btn";
    cancelBtn.addEventListener("click", () => {
      event.seats++;
      updateUI(event.id);
      alert(`Cancelled registration for ${event.name}`);
    });
    card.appendChild(cancelBtn);

    container.appendChild(card);
  });
}

// Update UI for a specific event after register/cancel
function updateUI(eventId) {
  // Just re-render all events here for simplicity
  renderEvents();
}

// Initial render
renderEvents();

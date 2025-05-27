// Sample event list with name, date, and seats
const events = [
  { name: "Community Clean-Up", date: "2025-06-15", seats: 5 },
  { name: "Charity Run", date: "2024-11-01", seats: 0 },      // full event
  { name: "Food Drive", date: "2023-09-10", seats: 10 },      // past event
  { name: "Neighborhood Watch", date: "2025-01-20", seats: 2 }
];

// Get today's date for comparison
const today = new Date();

const eventsContainer = document.getElementById("eventsContainer");

// Clear container initially
eventsContainer.innerHTML = "";

// Function to safely register for an event
function registerForEvent(event) {
  try {
    if (event.seats <= 0) {
      throw new Error("No seats available for " + event.name);
    }
    event.seats--;
    alert(`Successfully registered for ${event.name}. Seats left: ${event.seats}`);
    renderEvents(); // re-render events after registration
  } catch (error) {
    alert(error.message);
  }
}

// Function to render valid events
function renderEvents() {
  eventsContainer.innerHTML = ""; // Clear container

  // Filter upcoming events with seats
  const validEvents = events.filter(ev => {
    const eventDate = new Date(ev.date);
    return eventDate >= today && ev.seats > 0;
  });

  if (validEvents.length === 0) {
    eventsContainer.textContent = "No upcoming events with available seats.";
    return;
  }

  // Display each valid event
  validEvents.forEach(event => {
    const eventDiv = document.createElement("div");
    eventDiv.style.border = "1px solid #ccc";
    eventDiv.style.padding = "10px";
    eventDiv.style.margin = "10px 0";
    eventDiv.style.borderRadius = "5px";

    eventDiv.innerHTML = `
      <strong>${event.name}</strong><br>
      Date: ${event.date}<br>
      Seats Available: ${event.seats} <br>
      <button>Register</button>
    `;

    // Attach event listener for registration button
    eventDiv.querySelector("button").addEventListener("click", () => registerForEvent(event));

    eventsContainer.appendChild(eventDiv);
  });
}

// Initial render
renderEvents();

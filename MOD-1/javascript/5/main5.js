// Event class definition
class Event {
  constructor(name, date, seats) {
    this.name = name;
    this.date = new Date(date);
    this.seats = seats;
  }

  // Prototype method to check seat availability
  checkAvailability() {
    return this.seats > 0 ? "Seats Available" : "Sold Out";
  }
}

// Create sample events
const event1 = new Event("Community Picnic", "2025-07-10", 12);
const event2 = new Event("Tech Talk", "2024-11-20", 0);

// Function to list keys and values of an object
function listObjectEntries(obj) {
  return Object.entries(obj).map(([key, val]) => `${key}: ${val}`).join(", ");
}

const outputDiv = document.getElementById("output");

function displayEvent(event) {
  const keysValues = listObjectEntries(event);
  return `
    <div style="border:1px solid #ccc; padding:10px; margin:10px 0;">
      <strong>${event.name}</strong> (${event.date.toDateString()})<br>
      Seats: ${event.seats} <br>
      Availability: ${event.checkAvailability()}<br>
      <em>Properties:</em> ${keysValues}
    </div>
  `;
}

// Render events
outputDiv.innerHTML = displayEvent(event1) + displayEvent(event2);

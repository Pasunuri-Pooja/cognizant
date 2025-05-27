// Initial event list
const events = [
  { id: 1, name: "Community Clean-Up", category: "Community", seats: 5 },
  { id: 2, name: "Charity Run", category: "Fitness", seats: 10 },
  { id: 3, name: "Book Club", category: "Education", seats: 8 },
];

// Closure to track total registrations per category
function createRegistrationTracker() {
  const registrations = {};

  return {
    register(category) {
      if (!registrations[category]) {
        registrations[category] = 0;
      }
      registrations[category]++;
      console.log(`Registered for category "${category}": total now ${registrations[category]}`);
    },
    getRegistrations() {
      return { ...registrations };
    }
  };
}

const registrationTracker = createRegistrationTracker();

// Add new event function
function addEvent(event) {
  events.push(event);
  console.log(`Added event: ${event.name} in category ${event.category}`);
}

// Register user for an event (decrease seats and track registration)
function registerUser(eventId) {
  const event = events.find(e => e.id === eventId);
  if (!event) {
    console.error("Event not found");
    return;
  }
  if (event.seats <= 0) {
    alert(`Sorry, no seats left for ${event.name}`);
    return;
  }
  event.seats--;
  registrationTracker.register(event.category);
  alert(`Registered for "${event.name}". Seats left: ${event.seats}`);
  displayEvents();
}

// Higher-order filter function: accepts callback predicate
function filterEventsByCategory(category, callback) {
  return events.filter(event => callback(event, category));
}

// Callback for exact category match
function categoryMatch(event, category) {
  return event.category.toLowerCase() === category.toLowerCase();
}

// DOM elements
const eventsList = document.getElementById("eventsList");

// Display events with register buttons
function displayEvents(filteredEvents = events) {
  eventsList.innerHTML = "";

  if (filteredEvents.length === 0) {
    eventsList.textContent = "No events found.";
    return;
  }

  filteredEvents.forEach(event => {
    const div = document.createElement("div");
    div.style.border = "1px solid #ddd";
    div.style.padding = "10px";
    div.style.margin = "10px 0";
    div.innerHTML = `
      <strong>${event.name}</strong> (${event.category})<br>
      Seats Available: ${event.seats} <br>
      <button data-id="${event.id}">Register</button>
    `;
    div.querySelector("button").addEventListener("click", () => registerUser(event.id));
    eventsList.appendChild(div);
  });
}

// Example usage:

// Add a new event
addEvent({ id: 4, name: "Yoga Workshop", category: "Fitness", seats: 6 });

// Filter events by category "Fitness"
const fitnessEvents = filterEventsByCategory("Fitness", categoryMatch);

// Display filtered events (you can change this to displayEvents() to show all)
displayEvents(fitnessEvents);

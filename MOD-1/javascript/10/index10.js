// Sample list of events
const events = [
  { name: "Yoga Class", category: "Wellness", date: "2025-06-10" },
  { name: "Rock Concert", category: "Music", date: "2025-06-15" },
  { name: "Cooking Workshop", category: "Education", date: "2025-06-18" },
  { name: "Jazz Night", category: "Music", date: "2025-06-20" }
];

// Function with default parameter
function displayEvents(eventList = []) {
  const container = document.getElementById("eventsContainer");
  container.innerHTML = "";

  eventList.forEach(event => {
    // Destructure event object
    const { name, category, date } = event;

    const div = document.createElement("div");
    div.className = "event";
    div.innerHTML = `<strong>${name}</strong><br>Category: ${category}<br>Date: ${date}`;
    container.appendChild(div);
  });
}

// Clone with spread operator and filter
function showFilteredEvents(categoryFilter = "") {
  const clonedEvents = [...events]; // Shallow copy
  const filtered = clonedEvents.filter(({ category }) => category === categoryFilter);
  displayEvents(filtered);
}

// Initially show all events
displayEvents(events);

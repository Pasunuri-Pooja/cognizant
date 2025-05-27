// Initial array of events
const events = [
  { id: 1, name: "Music Festival", category: "Music" },
  { id: 2, name: "Art Workshop", category: "Arts" },
  { id: 3, name: "Cooking Class", category: "Food" },
];

// Add new events using push()
events.push(
  { id: 4, name: "Jazz Night", category: "Music" },
  { id: 5, name: "Baking Workshop", category: "Food" }
);

// Filter only music events
const musicEvents = events.filter(event => event.category.toLowerCase() === "music");

// Map to formatted display cards
const eventCards = musicEvents.map(event => {
  return `<div style="border:1px solid #aaa; margin:10px; padding:10px; border-radius:4px;">
    <strong>${event.name}</strong> — Category: ${event.category}
  </div>`;
});

// Render to the page
document.getElementById("eventsContainer").innerHTML = eventCards.join("");

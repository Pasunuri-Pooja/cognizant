const eventsContainer = document.getElementById("eventsContainer");
const spinner = document.getElementById("spinner");

// Mock API URL (you can replace with any public JSON endpoint)
const apiURL = "https://jsonplaceholder.typicode.com/posts?_limit=5";

// Utility to render events (simulate event names)
function renderEvents(events) {
  eventsContainer.innerHTML = "";
  events.forEach(event => {
    const div = document.createElement("div");
    div.className = "event-item";
    div.textContent = `Event: ${event.title}`; // Using "title" from mock API as event name
    eventsContainer.appendChild(div);
  });
}

// Fetch using .then() and .catch()
function fetchWithThen() {
  spinner.style.display = "block";
  eventsContainer.innerHTML = "";
  fetch(apiURL)
    .then(response => {
      if (!response.ok) throw new Error("Network response not OK");
      return response.json();
    })
    .then(data => {
      spinner.style.display = "none";
      renderEvents(data);
    })
    .catch(error => {
      spinner.style.display = "none";
      eventsContainer.textContent = `Error: ${error.message}`;
    });
}

// Fetch using async/await
async function fetchWithAsync() {
  spinner.style.display = "block";
  eventsContainer.innerHTML = "";
  try {
    const response = await fetch(apiURL);
    if (!response.ok) throw new Error("Network response not OK");
    const data = await response.json();
    spinner.style.display = "none";
    renderEvents(data);
  } catch (error) {
    spinner.style.display = "none";
    eventsContainer.textContent = `Error: ${error.message}`;
  }
}

document.getElementById("fetchThen").onclick = fetchWithThen;
document.getElementById("fetchAsync").onclick = fetchWithAsync;

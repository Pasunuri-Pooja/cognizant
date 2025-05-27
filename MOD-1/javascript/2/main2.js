// Declare event name and date as constants
const eventName = "Community Clean-Up";
const eventDate = "2025-06-15";

// Use let for mutable seats count
let availableSeats = 10;

// Function to update event info display
function displayEventInfo() {
  const info = `Event: ${eventName} | Date: ${eventDate} | Available Seats: ${availableSeats}`;
  document.getElementById('eventInfo').textContent = info;
}

// Increment seats on registration
function registerSeat() {
  if (availableSeats > 0) {
    availableSeats--;
    displayEventInfo();
  } else {
    alert("Sorry, no seats available!");
  }
}

// Decrement seats on cancellation
function cancelRegistration() {
  availableSeats++;
  displayEventInfo();
}

// Initial display
displayEventInfo();

// Attach event listeners
document.getElementById('registerBtn').addEventListener('click', registerSeat);
document.getElementById('cancelBtn').addEventListener('click', cancelRegistration);

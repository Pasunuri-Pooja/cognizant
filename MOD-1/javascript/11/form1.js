document.getElementById("eventForm").addEventListener("submit", function (event) {
  event.preventDefault(); // Prevent form from submitting

  const form = event.target;
  const { name, email, event: selectedEvent } = form.elements;

  let isValid = true;

  // Clear previous error messages
  document.getElementById("nameError").textContent = "";
  document.getElementById("emailError").textContent = "";
  document.getElementById("eventError").textContent = "";

  // Validate Name
  if (name.value.trim() === "") {
    document.getElementById("nameError").textContent = "Name is required.";
    isValid = false;
  }

  // Validate Email
  if (email.value.trim() === "") {
    document.getElementById("emailError").textContent = "Email is required.";
    isValid = false;
  } else if (!email.value.includes("@")) {
    document.getElementById("emailError").textContent = "Email is invalid.";
    isValid = false;
  }

  // Validate Event
  if (selectedEvent.value === "") {
    document.getElementById("eventError").textContent = "Please select an event.";
    isValid = false;
  }

  if (isValid) {
    alert(`Thank you ${name.value}! You are registered for the ${selectedEvent.value}.`);
    form.reset(); // Optional: reset form after successful submission
  }
});

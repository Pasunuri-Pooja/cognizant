document.getElementById("registrationForm").addEventListener("submit", function (event) {
  event.preventDefault();

  console.log("Form submission started.");

  const form = event.target;
  const name = form.elements.name.value.trim();
  const email = form.elements.email.value.trim();

  console.log("Collected name:", name);
  console.log("Collected email:", email);

  const payload = {
    name,
    email
  };

  console.log("Payload to send:", payload);

  const messageBox = document.getElementById("message");
  messageBox.textContent = "Submitting...";

  // Add a breakpoint here for inspection
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(payload)
  })
    .then(response => {
      console.log("Response status:", response.status);
      if (!response.ok) throw new Error("Server error");
      return response.json();
    })
    .then(data => {
      console.log("Response data:", data);
      messageBox.textContent = `✅ Registration successful, ${data.name || name}!`;
      form.reset();
    })
    .catch(error => {
      console.error("Registration error:", error);
      messageBox.textContent = "❌ Failed to register. Check console for details.";
    });
});

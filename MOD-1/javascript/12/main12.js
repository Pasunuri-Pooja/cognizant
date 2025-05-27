document.getElementById("registrationForm").addEventListener("submit", function (event) {
  event.preventDefault();

  const form = event.target;
  const name = form.elements.name.value.trim();
  const email = form.elements.email.value.trim();

  const messageBox = document.getElementById("message");
  messageBox.textContent = "Sending registration...";

  // Simulate delay
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ name, email })
    })
      .then(response => {
        if (!response.ok) throw new Error("Server error");
        return response.json();
      })
      .then(data => {
        messageBox.textContent = `✅ Registered successfully! Thank you, ${data.name}.`;
        form.reset();
      })
      .catch(error => {
        messageBox.textContent = `❌ Registration failed. Please try again.`;
        console.error(error);
      });
  }, 2000); // 2 second simulated delay
});

// Fetch weather data from API
function fetchWeather() {
    const apiKey = 'YOUR_API_KEY'; // Replace with your API key
    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?lat={LAT}&lon={LON}&appid=${apiKey}`;

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            // Extract relevant weather information
            const weatherDescription = data.weather[0].description;
            const temperature = Math.round(data.main.temp - 273.15); // Convert Kelvin to Celsius

            // Display weather on the page
            document.getElementById('weather').innerHTML = `
                <h2>Current Weather</h2>
                <p>Description: ${weatherDescription}</p>
                <p>Temperature: ${temperature}°C</p>
            `;
        })
        .catch(error => {
            console.error('Error fetching weather:', error);
        });
}

// Call fetchWeather function when page loads
window.onload = fetchWeather;

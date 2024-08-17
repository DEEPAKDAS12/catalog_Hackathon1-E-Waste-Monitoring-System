E-Waste Monitoring System
Overview
The E-Waste Monitoring System is a console-based Java application designed to help users manage the disposal and recycling of electronic waste (e-waste). This system allows users to register, log in, submit e-waste collection requests, track their requests, and view available recycling centers. The system is built using core Java technologies and demonstrates a practical implementation of user management, request handling, and basic I/O operations.

Purpose
The main purpose of this project is to provide a simple, yet functional system for managing e-waste disposal. By implementing this project, users can:

Register and log in to the system.
Submit e-waste collection requests.
Track the status of their requests.
View available recycling centers in their area.
This project can be expanded and adapted to include additional features or integrated into larger systems with more complex requirements.

Technologies Used
This project is implemented using the following Java technologies:

Core Java: The project is built using fundamental Java concepts such as object-oriented programming, collections, and file handling.
Java Collections Framework: ArrayList, HashMap, and other collections are used to manage data like users, requests, and recycling centers.
Java Swing (for console-based password input): The JPasswordField class is used to securely capture user passwords, hiding the input characters with asterisks.
Java I/O: Basic I/O operations are used to interact with the user through the console.
Project Structure
The project is organized into the following classes:

1. User Class
This class represents a user of the e-waste monitoring system. It contains:

Attributes: username and password.
Purpose: To store and manage user credentials.
2. CollectionRequest Class
This class represents a user's e-waste collection request. It contains:

Attributes: user (username of the requester), description (details of the e-waste), and status (status of the request, e.g., "Pending").
Purpose: To manage and track the e-waste collection requests submitted by users.
3. RecyclingCenter Class
This class represents a recycling center where e-waste can be processed. It contains:

Attributes: name (name of the recycling center) and contact (contact details).
Purpose: To store and display information about recycling centers available for e-waste disposal.
4. EWasteMonitoringSystem Class
This is the main class that drives the application. It contains:

Attributes: users (a map of registered users), requests (a list of collection requests), recyclingCenters (a list of available recycling centers), and scanner (for reading user input).
Methods:
main(): The entry point of the application. Handles the main menu and user interaction.
initializeRecyclingCenters(): Initializes the list of available recycling centers with some predefined entries.
register(): Allows new users to register by providing a username and password.
login(): Allows existing users to log in by entering their credentials.
userMenu(): Displays the menu for logged-in users, enabling them to submit requests, track their requests, and view recycling centers.
requestCollection(): Allows logged-in users to submit a new e-waste collection request.
trackRequests(): Displays all the collection requests made by the users.
viewRecyclingCenters(): Displays the list of available recycling centers.
readPassword(): Captures the password input securely, hiding the characters with asterisks.
How to Run the Project
Clone the Repository:
bash
Copy code
git clone https://github.com/yourusername/ewaste-monitoring-system.git
Compile the Code:
Navigate to the project directory and compile the code using the following command:
bash
Copy code
javac EWasteMonitoringSystem.java
Run the Application:
Execute the compiled code using:
bash
Copy code
java EWasteMonitoringSystem
Interact with the Application:
Register or log in to start using the application.
Submit and track e-waste collection requests.
View the list of available recycling centers.
Future Enhancements
This project can be extended with the following features:

Database Integration: Store user data, requests, and recycling center information in a database.
User Notifications: Send notifications to users when their requests are processed.
Admin Interface: Provide an interface for administrators to manage users and recycling centers.
Advanced Search: Implement search functionality to find recycling centers based on location or services offered.

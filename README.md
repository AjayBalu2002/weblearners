Sure, I can add a section about API endpoints to the README file. Here's an updated version of the README file with an API Endpoints section:

```markdown
# Blog Post Application

The Blog Post Application is a web-based platform for creating and managing blog posts. It provides users with the ability to create, edit, and delete blog posts, as well as add comments to existing posts. This README file provides an overview of the application's features, setup instructions, API endpoints, and usage guidelines.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database Models](#database-models)
- [Contributing](#contributing)
- [License](#license)

## Features

The Blog Post Application offers the following key features:

- **User Registration:** Users can register with their name, email, and password.

- **User Authentication:** Registered users can log in securely using their credentials.

- **Create Blog Posts:** Authenticated users can create new blog posts with a title and content.

- **Edit and Delete Posts:** Users can edit their own posts and delete them if needed.

- **Add Comments:** Users can comment on existing blog posts.

- **JWT Authentication:** JSON Web Tokens (JWT) are used for secure user authentication.

## Technologies Used

The application is built using the following technologies:

- **Spring Boot:** Backend development is powered by Spring Boot, providing a robust and scalable server.

- **Spring Security:** Spring Security is used to handle user authentication and authorization.

- **Spring Data JPA:** JPA (Java Persistence API) is used to interact with the database.

- **React.js:** The frontend is built using React.js, providing a dynamic and responsive user interface.

- **Axios:** Axios is used to make HTTP requests between the frontend and backend.

- **MySQL:** The MySQL database is used to store user data, blog posts, and comments.

## Setup

Follow these steps to set up and run the Blog Post Application:

1. **Clone the Repository:**

   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory:**

   ```bash
   cd blog-post-app
   ```

3. **Backend Setup:**

   - Ensure you have Java and Maven installed.
   - Navigate to the `backend` directory and run:

     ```bash
     mvn spring-boot:run
     ```

4. **Frontend Setup:**

   - Navigate to the `frontend` directory and run:

     ```bash
     npm install
     npm start
     ```

5. **Access the Application:**

   - Open a web browser and access the application at `http://localhost:3000`.

## Usage

1. **Registration and Login:**

   - Register a new account with your name, email, and password.
   - Log in using your registered email and password.

2. **Creating Blog Posts:**

   - After logging in, you can create new blog posts by providing a title and content.

3. **Editing and Deleting Posts:**

   - You can edit and delete your own posts by navigating to the post details page.

4. **Adding Comments:**

   - On the post details page, you can add comments to the blog post.

5. **JWT Authentication:**

   - The application uses JWT for secure authentication. Tokens are generated upon successful login.

## API Endpoints

Here are the main API endpoints provided by the application:

- **Create a New User:**

  ```
  POST /users/new
  ```

- **Get User by ID:**

  ```
  GET /users/usernew
  ```

- **User Login and Token Generation:**

  ```
  POST /users/login
  ```

- **Get User ID by Email:**

  ```
  POST /users/getuserid
  ```

- **Get Username by ID:**

  ```
  POST /users/getusername/{id}
  ```

- **Create a New Blog Post:**

  ```
  POST /posts
  ```

- **Get All Blog Posts:**

  ```
  GET /posts
  ```

- **Get Blog Post by ID:**

  ```
  GET /posts/{postId}
  ```

- **Update Blog Post by ID:**

  ```
  PUT /posts/{postId}
  ```

- **Delete Blog Post by ID:**

  ```
  DELETE /posts/{postId}
  ```

- **Create Comment on a Blog Post:**

  ```
  POST /posts/{postId}/comments
  ```

- **Get Comments for a Blog Post:**

  ```
  GET /posts/{postId}/comments
  ```

- **Update Comment by ID:**

  ```
  PUT /comments/{commentId}
  ```

- **Delete Comment by ID:**

  ```
  DELETE /comments/{commentId}
  ```

Please note that some endpoints require user authentication using JWT tokens.

## Database Models

The application uses several database models to store data. Here are some key models:

- **UserInfo:** Stores user information, including name, email, password, and roles.

- **Auth:** Stores authentication tokens and expiration times for users.

- **CommentModel:** Stores comments made by users on blog posts.

Please refer to the code for more details on the database models and their relationships.

## Contributing

Contributions to this project are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository to your GitHub account.

2. Create a new branch for your feature or bug fix:

   ```bash
   git checkout -b feature-name
   ```

3. Make your changes, commit them, and push to your branch:

   ```bash
   git commit -m 'Description of your changes'
   git push origin feature-name
   ```

4. Create a pull request to the `main` branch of the original repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to customize this README file based on your project's specific details and requirements. Include additional information or sections as needed to provide a comprehensive overview of your application.
```

In this updated README file, I've added an "API Endpoints" section that lists the main API endpoints provided by the application along with their HTTP methods and routes. You can customize this section further to provide additional details about each endpoint if needed.

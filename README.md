 
# Blogify - A Spring Boot Blog API


Blogify is a RESTful API built using Spring Boot that provides backend functionality for a blogging platform. It allows users to manage articles, categories, and user accounts for a seamless blogging experience.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features

- User registration and authentication
- Create, edit, and delete articles
- Assign articles to different categories
- Fetch articles by category or author
- Search for articles by keywords
- User-friendly and secure authentication process
- RESTful API architecture

## Getting Started

Follow these instructions to set up and run the Blogify API on your local machine.

1. Clone the repository:

```bash
git clone https://github.com/your-username/blogify.git
cd blogify
```

2. Configure the application properties:

Open `src/main/resources/application.properties` and update the database configuration according to your environment.

3. Build and run the application:

```bash
./mvnw spring-boot:run
```

The API will be accessible at `http://localhost:8080`.

## Usage

Once the application is up and running, you can use tools like `curl`, Postman, or any API client to interact with the endpoints. Refer to the [API Endpoints](#api-endpoints) section for a list of available endpoints and their usage.

## API Endpoints

For detailed information on API endpoints and their usage, please refer to the [API Documentation](link_to_your_api_docs).

## Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL (or your preferred database)
- Maven (or Gradle)
- JSON Web Tokens (JWT) for authentication
- RESTful API principles

## Contributing

Contributions are always welcome! If you'd like to contribute to Blogify, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature/fix.
3. Commit your changes with descriptive commit messages.
4. Push your changes to your branch.
5. Submit a pull request explaining the changes you've made.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
MIT License

Copyright (c) 2023 Yusuf Karaaslan

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

```

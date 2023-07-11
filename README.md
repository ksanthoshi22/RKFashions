# RKFASHIONS Jewelry Store

## Description

RKFASHIONS Jewelry Store is a web-based application that allows users to shop the latest jewelry collection and send their inquiries. Users can create an account to access the shopping feature. The application also provides an admin portal where administrators can log in to manage products, categories, and view customer inquiries.

## Features

- User Registration: Users can create an account to shop for jewelry.
- Product Catalog: Display the latest jewelry collection for users to browse and purchase.
- Enquiry Submission: Users can send inquiries about products.
- Admin Registration:If an email starts with prefix "admin", the user will be assigned to ADMIN role.
  eg: admin_rk@gmil.com
- Admin Dashboard: Separate Page for administrators to manage products, categories, and view customer inquiries.

- Admin Registration: Admins can create an account to manage .
- Product Management: Add, update, and delete products.
- Category Management: Manage jewelry categories.
- Security: Implemented using Spring Security for user authentication and authorization.

## Installation

1. Clone the repository: `git clone https://github.com/ksanthoshi22/RKFashions`
2. Navigate to the project directory: `cd rkfashions-jewelry-store`
3. Install the necessary dependencies: `mvn clean install`
4. Run the application: `java -jar target/rkfashions-jewelry-store.jar`

## Usage

1. Open a web browser and go to `http://localhost:8080`
2. Register an account as a user to access the shopping features.
3. Browse the product catalog and add items to the cart.
4. Feel free drop a enquiry message from contact page.
5. Admins can log in using the admin credentials navigate to admin portal by clicking Admin in nav bar to manage products, categories, and view inquiries.
6. Feel free to add categories and products from Admin page , those products will reflect in shop page. which User can view products by category and able to add to cart.
## Technologies Used

HTML | CSS | JavaScript | Thymeleaf | MySQL | SQL Workbench | Spring Boot | Spring Security | Spring Data JPA
## Database Schema

![schemadiagram.png](target%2Fschemadiagram.png)

## Contributing

Contributions are welcome! If you have any suggestions or found a bug, please open an issue or submit a pull request.

## Contact

For any questions or inquiries, please contact:

- Name: Santhoshi Komirelly
- Email: skomirelly2@gmail.com
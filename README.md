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

## Technologies Used

HTML | CSS | JavaScript | Thymeleaf | MySQL | SQL Workbench | Spring Boot | Spring Security | Spring Data JPA

## Installation

1. Clone the repository: `git clone https://github.com/ksanthoshi22/RKFashions`
2. Navigate to the project directory: `cd rkfashions-jewelry-store`
3. Install the necessary dependencies: `mvn clean install`
4. Run the application: `java -jar target/rkfashions-jewelry-store.jar`

##  Database Configuration:
### Prerequisites
- MySQL database installed
- Database connection details (host, port, username, password)

### Database Setup

1. Create a new MySQL database
2. Update the database connection settings in the application properties file (`application.properties`) with the appropriate values:

## Create Database

  create database rkfashions1;

## Application Start Up
Run the Application before executing the Queries.


### Category Table

```sql
INSERT INTO rkfashions1.category VALUES (1, 'Chokers');
INSERT INTO rkfashions1.category VALUES (2, 'Earrings');
INSERT INTO rkfashions1.category VALUES (3, 'Longsets');
INSERT INTO rkfashions1.category VALUES (4, 'Bangles');
```
### Product Table
Run the following SQL queries to populate the product table with sample data:
```sql

INSERT INTO rkfashions1.product VALUES (1, 'Pure Coral Set', 'IMG_2752.jpg', 'Coral Necklace', 65, 1, 1);
INSERT INTO rkfashions1.product VALUES (2, 'Fabulous Earrings', 'IMG_3045.jpg', 'Oxidized Earrings', 10, 2, 2);
INSERT INTO rkfashions1.product VALUES (3, 'Beautiful Oxidized set', 'IMG_3052.jpg', 'Oxidized Set', 35, 2, 3);
INSERT INTO rkfashions1.product VALUES (4, 'Beautiful Green Beads Set with Broucher', 'IMG_3078.jpg', 'Beads Set with Broucher', 65, 1, 3);
INSERT INTO rkfashions1.product VALUES (5, 'Fabulous Earrings', 'Oxidized Buttas.jpeg', 'Oxidized Buttalu', 15, 3, 2);
INSERT INTO rkfashions1.product VALUES (6, 'Pearls Choker with pendant', 'WhatsApp Image 2023-06-01 at 3.21.02 PM.jpeg', 'Pearl Choker', 55, 2, 1);
INSERT INTO rkfashions1.product VALUES (7, 'Gorgeous Kundhan Bangles', 'WhatsApp Image 2023-06-04 at 4.44.14 PM (1).jpeg', 'Kundhan Bangles', 35, 2, 4);

```
## Database Schema
![schemadiagram.png](target%2Fschemadiagram.png)

## Usage

1. Open a web browser and go to `http://localhost:8080`
2. Register an account as a user to access the shopping features.
3. Browse the product catalog and add items to the cart.
4. Feel free drop a enquiry message from contact page.
5. Admins can log in using the admin credentials navigate to admin portal by clicking Admin in nav bar to manage products, categories, and view inquiries.
6. Feel free to add categories and products from Admin page , those products will reflect in shop page. which User can view products by category and able to add to cart.

 
 
 ## Contact

For any questions or inquiries, please contact:

- Name: Santhoshi Komirelly
- Email: skomirelly2@gmail.com
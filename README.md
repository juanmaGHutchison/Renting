Rest Application made with Spring.
The app is about Users that rent Cars.
USER 1 ------- n CAR
USER 1 ------- n RENT
CAR  n ------- 1 USER
CAR  1 ------- n RENT
RENT n ------- 1 USER
RENT n ------- 1 CAR

DTO
USER(id, name)
CAR(id, model, brand)
RENT(USER, CAR, initDate, finalDate, price)

RESULTRENT(title: CAR.brand + CAR.model, initDate, finalDate, price) 

We want 
The profit of a given car in a rank date.
How much cars has a user rented.
Mock Rent Service.

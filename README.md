Rest Application made with Spring. <br />
The app is about Users that rent Cars. <br />
USER 1 ------- n CAR <br />
USER 1 ------- n RENT <br />
CAR  n ------- 1 USER <br />
CAR  1 ------- n RENT <br />
RENT n ------- 1 USER <br />
RENT n ------- 1 CAR <br />

DTO <br />
USER(id, name) <br />
CAR(id, model, brand) <br />
RENT(USER, CAR, initDate, finalDate, price) <br />

RESULTRENT(title: CAR.brand + CAR.model, initDate, finalDate, price) <br /> 

We want <br />
The profit of a given car in a rank date. <br />
How much cars has a user rented. <br />
Mock Rent Service. <br />

# Parking App

```note: app will not be work as expected if the parent folder used to unzip this projects contain Whitespace, for example: '/Assignment Erik/parking-lot-1.4.2'. The correct one should be '/Assignment-Erik/parking-lot-1.4.2' ```

The app consist of `main` and `test` package.

Source of `main` package is the package who does all the logical process for parking management.

While in `test` package, all the process logic are tested whether meet the requirement or not.    

## Prerequisites
This project using maven 3.5.4 in order to install all the dependencies.

There are only 1 dependency, JUNIT 1.4 which used for unit test.

## How to run 

In order to run the App, first run `./setup` inside `parking-lot-1.4.2/parking_lot/bin` to Install Dependencies, Build/Compile and run Test Suite.

- How to run using interactive command prompt
execute `./parking_lot` or 
`java -jar target/parkinglot-1.0-SNAPSHOT.jar`

- How to run using a filename on 1 arguments
execute `./parking_lot file_inputs.txt` or `java -jar target/parkinglot-1.0-SNAPSHOT.jar file_inputs.txt`

for example, after run `./setup`, just run this command to see the result `./parking_lot ../functional_spec/fixtures/file_input.txt`

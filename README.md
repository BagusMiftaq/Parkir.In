
# Parkir.In

'Parkirin' is an application to assist in administrative or transaction processes in managing parking space rentals. 
This application helps to record vehicle users who rent parking lots in which there are transactions to calculate parking rental prices based on the type of parking space rented and the duration of the rental including fines if the rental time exceeds the previously agreed rental deadline.

## Feature Scope

### Vehicle Feature
- Register the vehicle and its owner.
- Get list of registered vehicles.

### Owner Feature
- Get list of registered owner.
- Search registered owner by its name.
- Register an owner.

### Parking Feature
- Register a vehicle to start leasing a parking space.
- Get list of vehicles that perform parking rentals.
- Register a vehicle Register the vehicle for checkout from the parking lot.
- Get list of vehicles that perform checkout.

### Report Feature
- Get Report from all time.
- Get Report by Month in a year.
- Get Report Daily.

#### another minor feature just for help to make sure you can make every entity one by one.

### Future Feature
- Safe delete for some feature.
- Update value of the entity for some feature.
- Using authorization for transactional section.
- Download reporting as csv file

## How to use?

1. Make sure all dependencies are reloaded.
2. Copy the environment from [environment.env](https://github.com/BagusMiftaq/Parkir.In/blob/master/environment.env) inside the project to your application environment.
3. Create database "db_parkirin" or same as DB_NAME variable inside the environment.
5. Run the application, the table entity will automatically created.
5. Open Swagger UI, link : http://localhost:8123/swagger-ui/index.html# 
   Altenatively you can use Postman but the localhost port and the endpoint must be the same as mine.
6. Now you can start trying to use the API POST or GET on the Swagger UI.
7. You have to create some value for the entity but dont worry, I already add sql file for the data.
   Excecute the [data-query.sql](https://github.com/BagusMiftaq/Parkir.In/blob/master/data-query.sql) to your RDMS, example : PgAdmin.
8. If the data is ready, you can try to use some of GET API on the Swagger espesially the Major Feature.

# Thank's
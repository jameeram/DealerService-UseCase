# Dealer Service Use Case

- Used HSQLDB In memory database for data store.

- `DataSet -- Dataset table which has string id as primary  
- `Dealer` - Dealer has reference of dataSetId and one to many relation of Vehicles
- `Vehicle` - Vehilce has unique id and references of dataSetId and dealerId

port : 8082

end points as per specficiation.
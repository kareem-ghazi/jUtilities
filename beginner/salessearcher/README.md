# SalesSearcher

Searches through sales data and prints out the order details.

## What is this? ##

A simple CSV file parser that parses sales data and stores it in compilation. You can search for this data using an order ID. The example file used was taken from [this](http://eforexcel.com/wp/downloads-18-sample-csv-files-data-sets-for-testing-sales/) website. This program currently supports 8 data fields:

- `regions` - Area of the order.
- `countries` - Country of the order.
- `itemTypes` - Type of item in the order.
- `orderDates` - Date of the order.
- `orderIDs` - ID of the order.
- `unitsSold` - Amount of the item type in the order.
- `unitsPrice` - Price of the unit.
- `totalRevenues` - Total revenue made from the order.

## How to use? ##

Enter the order ID of an order to print out the details for it.
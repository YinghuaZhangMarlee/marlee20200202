use AdventureWorks2008R2;

SELECT ProductID, Product.Name, CAST(SellStartDate AS date) AS StartSellDate 
	FROM Production.Product 
	WHERE Color = 'RED' 
		AND datediff(second, SellStartDate, CAST('2005-01-01' AS datetime)) < 0 
	ORDER BY SellStartDate;

SELECT COUNT(ProductID) AS CountProduct 
	FROM Production.Product 
	WHERE DaysToManufacture = 2 
		AND Color = 'BLACK';

SELECT ProductID, Product.Name, ListPrice 
	FROM Production.Product 
	WHERE ListPrice > 10 + (SELECT AVG(ListPrice) 
								FROM Production.Product) 
	ORDER BY ListPrice DESC;

SELECT p.ProductID, p.Name, SUM(s.OrderQty) AS TotalQuantity 
	FROM Production.Product AS p 
	JOIN Sales.SalesOrderDetail AS s 
	ON p.ProductID = s.ProductID 
	WHERE p.Color = 'RED' 
	GROUP BY p.ProductID, p.Name 
	HAVING SUM(s.OrderQty) > 2000;

SELECT c.CustomerID 
	FROM Sales.Customer AS c 
	WHERE c.CustomerID in (SELECT DISTINCT soh.CustomerID 
							FROM Sales.SalesOrderHeader AS soh 
							JOIN Sales.SalesOrderDetail AS sod 
							ON soh.SalesOrderID = sod.SalesOrderID 
							WHERE sod.ProductID in (710, 715)) 
		AND c.CustomerID NOT IN(SELECT DISTINCT soh.CustomerID 
							FROM Sales.SalesOrderHeader AS soh 
							JOIN Sales.SalesOrderDetail AS sod 
							ON soh.SalesOrderID = sod.SalesOrderID 
							WHERE sod.ProductID = 716) 
	ORDER BY c.CustomerID;

SELECT p.BusinessEntityID AS CustomerID, p.LastName, p.FirstName, ov.LowestValues, ov.HighestValues 
	FROM (SELECT soh.CustomerID, 
				MIN(sod.LineTotal) AS LowestValues, 
				MAX(sod.LineTotal) AS HighestValues 
		FROM Sales.SalesOrderHeader AS soh 
		JOIN Sales.SalesOrderDetail AS sod 
		ON soh.SalesOrderID = sod.SalesOrderID 
		GROUP BY soh.CustomerID) AS ov
	JOIN Person.Person AS p 
	ON ov.CustomerID = p.BusinessEntityID 
	ORDER BY p.BusinessEntityID;
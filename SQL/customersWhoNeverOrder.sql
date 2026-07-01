# Write your MySQL query statement below
SELECT 
    c.name AS Customers 
FROM 
    Customers c 
WHERE 
    c.Id NOT IN (SELECT o.customerId FROM orders o);

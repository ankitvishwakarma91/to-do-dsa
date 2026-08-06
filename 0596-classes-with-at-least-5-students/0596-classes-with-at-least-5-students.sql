# Write your MySQL query statement below
select 
-- count(class) as class 
class
from Courses
group by class having count(class) >= 5;
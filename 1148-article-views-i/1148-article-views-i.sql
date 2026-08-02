# Write your MySQL query statement below
select DISTINCT author_id AS ID from Views where author_id = viewer_id ORDER BY ID ASC;
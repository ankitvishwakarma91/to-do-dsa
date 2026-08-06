# Write your MySQL query statement below

select 
s.user_id,
ROUND(
    IFNULL(
        SUM(case when c.action = 'confirmed' then 1 else 0 END)
        / count(c.action),
        0
    ),
    2
) as confirmation_rate 
from Signups s
left join Confirmations c
on s.user_id = c.user_id
group by user_id;
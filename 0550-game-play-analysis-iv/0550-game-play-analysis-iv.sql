# Write your MySQL query statement below
SELECT 
    ROUND(
        COUNT(DISTINCT CASE WHEN DATEDIFF(a.event_date, first_logins.first_date) = 1 THEN a.player_id END) 
        / COUNT(DISTINCT first_logins.player_id), 
        2
    ) AS fraction
FROM (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
) AS first_logins
LEFT JOIN Activity AS a 
    ON first_logins.player_id = a.player_id 
    AND DATEDIFF(a.event_date, first_logins.first_date) = 1;

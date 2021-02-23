/* Problem 180. Consecutive Numbers */

/* Best solution - use window function (analytic function) */
SELECT DISTINCT temp.Num AS ConsecutiveNums
FROM (
       SELECT
          Num,
          LEAD(Num) OVER (ORDER BY Id) AS `lead`,
          LAG(Num) OVER (ORDER BY Id) AS `lag`
       FROM Logs
    ) AS temp
WHERE temp.Num = temp.lead
AND temp.Num = temp.lag      
;


/* 
   Leetcode Solution
   Not good
   This solution ignores scenerias that records are deleted & some Ids are missing
   For example:
   Id  Num
    1   1
    3   1
    4   1
    5   2
*/
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
;

/* 
    To improve leetcode solution
    This solution takes long time to run
*/
SELECT DISTINCT
     l1.Num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE l2.Id = (SELECT MIN(Id) FROM Logs WHERE Id > l1.Id)
      AND l3.Id = (SELECT MIN(Id) FROM Logs WHERE Id > l2.Id)
      AND l1.Num = l2.Num
      AND l2.Num = l3.Num
;
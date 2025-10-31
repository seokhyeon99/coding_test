SELECT A.ID, IFNULL(B.CHILD_COUNT,0) AS CHILD_COUNT
FROM ECOLI_DATA A LEFT JOIN (SELECT PARENT_ID, COUNT(*) AS 'CHILD_COUNT'
                             FROM ECOLI_DATA
                             WHERE PARENT_ID IS NOT NULL
                             GROUP BY PARENT_ID) B
                             ON A.ID = B.PARENT_ID
ORDER BY A.ID ASC
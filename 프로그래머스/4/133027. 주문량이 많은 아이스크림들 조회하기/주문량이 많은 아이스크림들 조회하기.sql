-- 코드를 입력하세요

SELECT C.FLAVOR
FROM
(
    SELECT A.FLAVOR, A.SUM + B.SUM AS TOTALSUM
    FROM
        (
            SELECT FLAVOR, SUM(TOTAL_ORDER) SUM
            FROM FIRST_HALF
            GROUP BY FLAVOR
        ) A
    JOIN
        (
            SELECT FLAVOR, SUM(TOTAL_ORDER) AS SUM
            FROM JULY
            GROUP BY FLAVOR
        ) B
    USING (FLAVOR)
    ORDER BY TOTALSUM DESC
    LIMIT 3
) C
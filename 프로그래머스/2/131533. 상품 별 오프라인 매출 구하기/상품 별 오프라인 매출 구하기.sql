SELECT
    A.PRODUCT_CODE,
    SUM(A.PRICE * B.SALES_AMOUNT) as SALES
FROM 
    PRODUCT A, OFFLINE_SALE B
WHERE 
    A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY 
    A.PRODUCT_CODE
ORDER BY 
    2 DESC, 1 ASC
    
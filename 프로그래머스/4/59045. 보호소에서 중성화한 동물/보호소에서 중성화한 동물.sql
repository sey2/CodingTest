SELECT
    A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM
    (SELECT ANIMAL_ID, ANIMAL_TYPE, NAME, SEX_UPON_INTAKE
     FROM ANIMAL_INS
     WHERE SEX_UPON_INTAKE LIKE 'Intact%') A,
     ANIMAL_OUTS B
WHERE
    A.ANIMAL_ID = B.ANIMAL_ID 
    AND (B.SEX_UPON_OUTCOME LIKE 'Spayed%'
    OR  B.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY 
    1 ;

    
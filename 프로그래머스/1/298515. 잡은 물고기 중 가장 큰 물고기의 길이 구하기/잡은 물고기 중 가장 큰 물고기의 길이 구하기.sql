select CONCAT(format(LENGTH, 2), 'cm') as MAX_LENGTH
from FISH_INFO
order by LENGTH desc limit 1;
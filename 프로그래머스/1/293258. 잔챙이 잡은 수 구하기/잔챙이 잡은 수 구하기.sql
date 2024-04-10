select count(id) as FISH_COUNT
from FISH_INFO
where length <= 10 or length is null
## Locker

[![Locker Build status](https://circleci.com/gh/Fatezhang/Locker.svg?style=svg)](https://app.circleci.com/pipelines/github/Fatezhang/Locker/)

A simple project to practice TDD.

## Task

| Given                        | When | Then                     |
| ---------------------------- | ---- | ------------------------ |
| 容量为3的柜子未存包，包id=1      | 存包 | 存储成功，获取一张存包票 |
| 容量为3的柜子存了2包(id=1, id=2)，包id=3     | 存包 | 存储成功，获取一张存包票 |
| 容量为2的柜子存了2包(id=1, id=2)，包id=3     | 存包 | 存储失败                 |
| 容量为2的柜子存了1包(id=1)，相同的包id=1（存两次）     | 存包 | 存储失败                 |
| 容量为2的柜子存了2包(id=1, id=2)，有效存包票bagId=1 | 取包 | 取包成功                 |
| 容量为2的柜子存了2包(id=1, id=2)，无效存包票(bagId=3) | 取包 | 取包失败               |
| 容量为2的柜子存了0包，无效存包票(bagId=1) | 取包 | 取包失败                 |
| 容量为2的柜子存了2包(id=1, id=2)，有效存包票(bagId=1) | 取包，再次取包 | 第一次成功，第二次取包失败                 |
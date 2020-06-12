## Locker

[![Locker Build status](https://circleci.com/gh/Fatezhang/Locker.svg?style=svg)](https://app.circleci.com/pipelines/github/Fatezhang/Locker/)

A simple project to practice TDD.

## Task

| Given                        | When | Then                     |
| ---------------------------- | ---- | ------------------------ |
| 容量为3的柜子未存包，包      | 存包 | 存储成功，获取一张存包票 |
| 容量为3的柜子存了2包，包     | 存包 | 存储成功，获取一张存包票 |
| 容量为3的柜子存了3包，包     | 存包 | 存储失败                 |
| 容量为3的柜子存了3包，有效存包票 | 取包 | 取包成功                 |
| 容量为3的柜子存了1包，有效存包票 | 取包 | 取包成功                 |
| 容量为3的柜子存了1包，无效存包票 | 取包 | 取包成功                 |
| 容量为3的柜子存了0包，存包票 | 取包 | 取包失败                 |
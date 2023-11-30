 # changeCommit.sh
  git filter-branch --commit-filter '
    if [ "$GIT_AUTHOR_EMAIL" = "" ];
    then
            GIT_AUTHOR_NAME="程序员小富";
            GIT_AUTHOR_EMAIL="515361725@qq.com";
            git commit-tree "$@";
    else
            git commit-tree "$@";
    fi' HEAD
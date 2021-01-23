#!/bin/bash
echo "Realizando merge automatico con develop"
currentBranch=$(git branch --show-current)
echo "Rama actual es $currentBranch"
output=$(git pull origin master)
code=$?

case $code in

  0)
    echo "Merge Automatico realizado exitosamente..."
    echo "Pusheando commits a rama $currentBranch"
    git push
    exit
    ;;

  1)
    echo -e "\e[31mMerge Automatico realizado parcialmente, es necesario resolver conflictos manualmente\e[0m"
    read;
    ;;

  128)
    echo -e "\e[31mMerge Automatico abortado...\e[0m"
    read;
    ;;

  *)
    echo -e "\e[31mError: codigo de error no contemplado\e[0m"
    read;
    ;;
esac
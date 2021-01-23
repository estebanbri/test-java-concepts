#!/bin/bash
echo "Realizando merge automatico con develop"
currentBranch=$(git branch --show-current)
echo "Rama actual es $currentBranch"
output=$(git pull origin master)
code=$?

case $code in

  0)
    echo -e "\e[32mMerge Automatico realizado exitosamente...\e[0m"
    echo "Pusheando commits a rama $currentBranch"
    git push
    ;;

  1)
    echo -e "\e[93Merge Automatico realizado parcialmente, es necesario resolver conflictos manualmente\e[0m"
    ;;

  128)
    echo -e "\e[31mMerge Automatico abortado...\e[0m"
    ;;

  *)
    echo -e "\e[31mError: codigo de error no contemplado\e[0m"
    ;;
esac
read;
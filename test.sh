#!/bin/bash
echo "Realizando merge automatico con develop"
currentBranch=$(git branch --show-current)
echo "Rama actual es $currentBranch"
output=$(git pull origin master)
code=$?

case $code in

  0)
    echo "\e[32mMerge Automatico realizado exitosamente..."
    echo "Pusheando commits a rama $currentBranch"
    git push
    ;;

  1)
    echo -e "\e[31mMerge Automatico realizado parcialmente, es necesario resolver conflictos manualmente"
    ;;

  128)
    echo -e "\e[31mMerge Automatico abortado..."
    ;;

  *)
    echo -e "\e[31mError: codigo de error no contemplado"
    ;;
esac
read;
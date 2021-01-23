#!/bin/bash
echo "Realizando merge automatico con develop"
currentBranch=$(git branch --show-current)
echo "Rama actual es $currentBranch"
output=$(git pull origin master)
code=$?
echo $code
case $code in

  0)
    echo "Merge Automatico realizado exitosamente..."
    git push
    ;;

  1)
    echo "Merge Automatico realizado parcialmente, es necesario resolver conflictos manualmente"
    ;;

  128)
    echo "Merge Automatico abortado..."
    ;;

  *)
    echo "Error: codigo de error no contemplado"
    ;;
esac

read;
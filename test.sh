#!/bin/bash
echo "*** Realizando merge automatico con develop ***"
echo

ramaFeature=$1

checkout=$(git checkout "$ramaFeature")
checkoutStatusCode=$?

if [[ $checkoutStatusCode -ne 0 ]];
then
  echo -e "\e[31mRama $ramaFeature no existe localmente...\e[0m"
  exit
fi

pull=$(git pull origin master)
pullStatusCode=$?

case $pullStatusCode in

  0)
    echo -e "\e[32mMerge Automatico realizado exitosamente...\e[0m"
    echo "Pusheando commits a rama $ramaFeature"
    git push
    ;;

  1)
    echo -e "\e[93mMerge Automatico realizado parcialmente, es necesario resolver conflictos manualmente\e[0m"
    ;;

  128)
    echo -e "\e[31mMerge Automatico abortado...\e[0m"
    ;;

  *)
    echo -e "\e[31mError: codigo de error no contemplado\e[0m"
    ;;
esac

echo "Presione cualquier tecla para finalizar...";
read;
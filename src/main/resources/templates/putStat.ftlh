<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table id="wordStat">
    <thead>
    <tr>
        <th>Word</th>
        <th>Stat</th>
    </tr>
    </thead>
    <body>
    <#list wordStat?keys as key>
        ${key} = ${wordStat[key]}
        <br>
    </#list>
    </body>
</table>
</body>
</html>
@import org.example.hexlet.dto.course.CourseDto
@param CourseDto course


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${course.getName()}</title>
</head>
<body>
<main>
    <ul>
        <li><b>Course name:</b> ${course.getName()}</li>
        <li><b>Course description:</b> ${course.getDescription()}</li>
        <li><b>Course id:</b> ${course.getId()}</li>
    </ul>
</main>
</body>
</html>

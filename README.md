# PowerFitBeans
**RN 2024.02.22 00:30hrs**
<br>
## Detalle de las modificaciones realizadas en la app para cada uno de los criterios de puntuación:
**1) Modificar el aspecto (look and feel) de las ventanas para hacerlas más atractivas y acorde con las tendencias actuales (p.ej. flat design, color scheme, etc.).**<br>
Se ha modificado el aspecto de la app con la librería de Flatlaf. Además, se ha añadido un toggle button para cambiar la apariencia a Dark Mode o Light Mode, favoreciendo así la apariencia y adaptando la app al gusto del usuario. También se ha modificado el fichero de configuración para tener un accent color amarillo/oro para adaptar la app a la imagen de la empresa.<br>
**2) Añadir iconos y/o otros elementos visuales a los componentes para mejorar la usabilidad de la interfaz.**<br>
Modificados los elementos gráficos de la web por iconos muy intuitivos y ya de sobra conocidos, escogiendolos todos de una única librería, dándole así una mayor consistencia en el diseño de toda la app. Además, se han elegido imágenes en formato SVG para favorecer la escalabilidad de las imágenes y su posible modificación de colores en futuras versiones. Otros aspectos que se han añadido para favorecer la usabilidad ha sido la creación de eventos al pasar el cursor sobre los componentes (cambio de cursor por defecto) y el evento del hover resaltando la actividad que está siendo revisada.<br>
**3) Modificar la fuente y componentes utilizados para mostrar texto de forma que éste resulte legible e inteligible.**<br>
Fuente modificada a tipo `Arial` en distintos tamaños en todos los `JLabel`, `JButton` y demás componentes para mejorar la legibilidad. Además, se han añadido tooltips en los distintos iconos y botones para dar feedback al usuario sobre la funcionalidad de los distintos elementos de la app.<br>
**4) Distribuir y agrupar los componentes de una manera más organizada y atractiva para el usuario.**<br>
Se han creado paneles y secciones para mejorar la organización de los componentes dentro de cada ventana. Además, se han creado alguna cabecera para insertar iconos de navegación a distintas pantallas (volver atrás, salir de la app, etc.).<br>
**5) Redefinir los Layouts de los diferentes contenedores (JFrame, JDialog, …), Anchors (anclajes), Auto Resizing, Min and Max Size, etc. para que la usabilidad de la interfaz no se vea afectada en caso de redimensionamiento de las ventana principal.**<br>
Modificadas todas las pantallas con el Layout que he creído más conveniente para favorecer la organización de todos los elementos de la ventana. También se han ajustado los tamaños, localización de los paneles (Norte, Este, etc.) y sus anclajes y tamaños mínimos y máximos donde se ha creido necesario.<br>
**6) Implementar la gestión de errores y excepciones necesaria, informando y dando feedback al usuario cuando sea necesario (no es necesario utilizar ninguna API de validación).**<br>
Se valida que el vídeo se encuentra en la nube y también que las credenciales de acceso son correctas, informando al usuario con el correspondiente mensaje si las credenciales proporcionadas no son correctas.<br>
**7) Clean code. Readable, maintainable, scalable. Naming things. Packages and project structure.**<br>
Desde el inicio del desarrollo de la app se ha tratado de organizar bien todo el código, creando las clases necesarias y organizando cada parte en su correspondiente paquete. Se ha seguido la convención del modo de como se recomienda nombrar las distintas constantes y variables. Además, todo el código está debidamente comentado en inglés para favorecer la escalabilidad y la depuración del código por terceras personas en caso de ser necesario. Creado los métodos que han sido necesarios, clases para ser utilizadas como interfaz y dando mayor seguridad y robustez al programa.<br>
**8) Evidencia treball continuat al repository de github. Generally meets the milestones deadlines.**<br>
He tratado de cumplir con las fechas orientativas en los plazos recomendados, proporcionando artículos y referencias interesantes que han sido consultados durante el desarrollo de esta unidad.
<br>
<br>
**RN 2024.02.10 13:30hrs**
<br>
I have found this useful info to overcome the issue changing the look & feel on the app:
<br>
https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
<br>
<br>
**RN 2024.01.31 23:30hrs**
<br>
Open-licensed SVG Vector and Icons (free download):
<br>
https://www.svgrepo.com/
<br>
<br>
**RN 2024.01.31 22:00hrs**
<br>
***Problem importing jar file into a `Maven` project***
<br>
I was struggling when trying to upload the `flatlaf-intellij-themes` library to my project, but then I have read carefully the explanations and navigated to https://search.maven.org/artifact/com.formdev/flatlaf-intellij-themes/3.3/jar?eh= and eventually, found the dependencies needed to be added to my `pom` file.
<br>
<br>
**RN 2024.01.31 21:00hrs**
<br>
***FlatLaf Tutorial - How to install flatlaf look and feel \(Part 1 and 2\)***
<br>
Video tutorial to do the basic setup in Netbeans.
<br>
https://www.youtube.com/watch?v=Dqlwr3uIeVM
<br>
<br>
**RN 2024.01.27 12:00hrs**
<br>
I have found some useful articles and YouTube videos related to the following topics:
<br>
***SVG vs PNG: What Are the Differences and When to Use Them***
<br>
https://kinsta.com/blog/svg-vs-png/
<br>
<br>
***Bulb Digital Channel: Tips and Tricks to make our UX Design simpler and nicer***
<br>
https://www.youtube.com/watch?v=rtxBKzReQXA
<br>
<br>
***Everything you should know about 8 point grid system in UX design***
<br>
Website, apps, dashboard, UI, etc. there is a variety of screen sizes. Pixel densities have continued to increase making the work of asset generation more complicated for designers. Utilizing number like 8 to size and space elements makes scaling for a wide variety of devices easy and consistent. Also, the majority of popular screen sizes are divisible by 8 which makes for an easy fit. The principle of 8pt Grid is that use multiples of 8 (8, 16, 24, 32, 40, 48, 56, etc.) to layout, dimensions, padding, and margin of elements.
<br>
https://uxplanet.org/everything-you-should-know-about-8-point-grid-system-in-ux-design-b69cb945b18d
<br>
<br>
***The 60–30–10 Rule***
<br>
What is the 60–30–10 Rule?
<br>
The 60–30–10 rule is a popular color theory used by interior designers, fashion designers, and graphic designers to create a balanced and harmonious color scheme. The rule states that a color scheme should consist of three colors in the following proportions:
<br>
* 60% of the dominant color
* 30% of the secondary color
* 10% of the accent color

The dominant color is the main color of the design, and it should be the most prominent and visible color. The secondary color is a complementary color that supports the dominant color and provides visual interest. The accent color is a pop of color that adds a bit of excitement and contrast to the design.
<br>
https://uxplanet.org/the-60-30-10-rule-a-foolproof-way-to-choose-colors-for-your-ui-design-d15625e56d25
<br>
<br>
**RN 2023.12.26 17:00hrs**
<br>
Found useful code to **convert SQL Timestamp to String**:
<br>
https://stackoverflow.com/questions/35170620/format-java-sql-timestamp-into-a-string<br>

***I had a problem with Github when doing the commits. It seems that the issue came after doing the merge from `main` branch to `master`. For some unknown reason, the commits were sent to another Github account instead of this repository***<br>
<br>
**RN 2023.12.24 20:50hrs**
<br>
Found code to insert the component into a JScrollPane
<br>
https://stackoverflow.com/questions/10346449/scrolling-a-jpanel<br>
<br>
**RN 2023.11.21 23:00hrs**
<br>
***Created Microsoft Azure Account and Blob Storage***
<br>
I have created a new container and a Blob Storage service and uploaded all the videos.
<br>
Useful YouTube video:
<br>
**Azure Blob Storage Containers - How to create a storage account and upload files, create folders**: https://youtu.be/M_1R0ZOlP-w
<br>


**RN 2023.11.12 22:00hrs**
<br>
***JTable in JAVA Swing | Update Selected Row From JTable***
<br>Working with JTables in Java.
<br>I have found this YouTube video very useful:
<br>https://www.youtube.com/watch?v=Tg62AxNRir4

**RN 2023.11.12 17:30hrs**
<br>
***Video Player*** not visible in JPanel.
<br>
***Solved***
<br>After trying different components (JPanel, JFrame and JDialog) I found out that the error was due to the updateUI method. This link helped me:
<br>https://java.hotexamples.com/es/examples/javax.swing/JScrollPane/updateUI/java-jscrollpane-updateui-method-examples.html

**RN 2023.11.08 14:30hrs**
<br>
***Error message*** in Netbeans when testing the VLC Video Player:
<br>
Native library (win32-x86-64/libvlc.dll) not found in resource path

***Path was not correct*** as per the following response, because the VLC was in 'C:\Program Files **(x86)**\VideoLAN', not in 'C:\Program Files\VideoLAN':
<br>
https://stackoverflow.com/questions/22885679/unable-to-load-libvlc

***Solved***
<br>I fixed it by uninstalling and re-installing VLC in the correct folder path.

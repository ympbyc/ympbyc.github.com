function circle (r, theta) {
  return new THREE.Vector2(
    r * Math.cos(theta), //x
    r * Math.sin(theta)  //y
  );
}

function disc (R,t,r,p) {
  var c = circle(R,t); //円周上の点
  return new THREE.Vector2(
    c.x + r * Math.cos(p) * Math.cos(t),
    c.y + r * Math.cos(p) * Math.sin(t)
  );
}

function torus (R,t,r,p) {
  var d = disc(R,t,r,p);
  return new THREE.Vector3(
    d.x,
    d.y,
    r * Math.sin(p)
  );
}

function makeBalls (scene, scale) {
  return [1,.9,.8,.7,.6,.5,.4,.3,.25,.2,.15,.1].map(function (i) {
      var ball = new THREE.Mesh(
          new THREE.SphereGeometry(i * scale,12,12),
          new THREE.MeshLambertMaterial({
              color: 0xF0BA32,
              ambient: 0xF0BA32
          })
      );
      ball.castShadow = true;
      ball.receiveShadow = false;
      scene.add(ball);
      return ball;
  });
}

document.addEventListener("DOMContentLoaded", function () {
    window.scrollTo(0,0);
    var renderer = new THREE.WebGLRenderer({
      alpha: true,
      antialiasing: true,
    });
    //renderer.shadowMapEnabled = true;
    //renderer.shadowMapType = THREE.PCFSoftShadowMap;
    var container = document.querySelector("#section-gallery .content");
    var cRect = container.getBoundingClientRect();
    console.log(cRect.width);

    var scale = 1;
    if (cRect.width < 600)
      scale = cRect.width / 600;

    var cHeight = 280;
    renderer.setSize(cRect.width, cHeight);
    //renderer.setClearColor(0x000000);
    renderer.domElement.style.margin = "-80px auto -80px auto";
    renderer.domElement.style.display = "block";
    container.appendChild(renderer.domElement);


    var scene = new THREE.Scene();
    var origin = new THREE.Vector3(0,0,0);
    var camera = new THREE.PerspectiveCamera(50, cRect.width / cHeight, 1, 100);
    camera.position.set(0,-37,7);
    camera.lookAt(origin);
    scene.add(camera);

    scene.add(new THREE.AmbientLight(0xbbbbbb));
    var dl = new THREE.DirectionalLight(0xffffff, 0.7);
    //dl.position.set(0,-120,7);
    dl.position.set(-30, -40, 7);
    dl.lookAt(new THREE.Vector3(0,0,0));
    dl.castShadow = true;
    dl.shadowDarkness = 1;
    scene.add(dl);

    var logo = new THREE.Mesh(
        new THREE.TextGeometry("PILOT Proto Lab", {
            size: 3 * scale,
            height: 1
        }),
        new THREE.MeshBasicMaterial({
            color: 0xffffff,
            ambient: 0xffffff,
            wireframe: true,
            wireframeLinewidth: 1
        })
    );
    logo.rotation.x = Math.PI/2;
    logo.position.x = -15 * scale;
    logo.position.z = -2 + 1/scale;
    scene.add(logo);

    var donut = new THREE.Mesh(
        new THREE.TorusGeometry(20 * scale, 2, 24,32),
        new THREE.MeshLambertMaterial({
            color: 0xD04255,
            ambient: 0xD04255,
            shading: THREE.FlatShading
        })
    );
    donut.material.transparent = true;
    donut.material.opacity = 0.9
    donut.receiveShadow = true;
    scene.add(donut);

    var balls = makeBalls(scene, scale);
    var balls2 = makeBalls(scene, scale);


    //animation
    var t = Math.PI;
    var x = 0;
    var deceleration_timer = null;
    var deceleration_delta  = 0.015;

    function outer_frame () {
      clearTimeout(deceleration_timer);
      deceleration_delta = 0;

      deceleration_timer = setTimeout(function () {
        deceleration_delta  = 0.015;
        requestAnimationFrame(frame);
      }, 100);

      requestAnimationFrame(frame);
    }

    function frame () {
        if (deceleration_delta > 0) {
          t += deceleration_delta;
          deceleration_delta -= 0.0004;
          if (deceleration_delta > 0) requestAnimationFrame(frame);
        }
        else
          t += 0.015;

        balls.forEach(function (ball, i) {
            t_ = t - i * (0.025 * (Math.cos(t) + 2));
            var c = torus(20 * scale, t_, 3, 10*t_);
            ball.position.set(c.x, c.y, c.z);
        });
        balls2.forEach(function (ball, i) {
          t_ = Math.PI -(t - i * (0.025 * (Math.cos(t) + 2)));
          var c = torus(20 * scale, t_, 0.4, 10*t_);
          ball.position.set(c.x, c.y, c.z)
        });
        donut.rotation.z = -t / 4;
        camera.position.z = 7 + Math.sin(2*t)*1.2;
        camera.lookAt(origin);
        renderer.render(scene, camera);
    }
    //requestAnimationFrame(frame);

    // fix to top
    var fixed = false;
    var section = document.getElementById("section-gallery");
    var sectionBelow = document.getElementById("section-usage");
    //    var ice = document.getElementById("ice-sound");

    window.addEventListener("scroll", function () {
      outer_frame();
      if (window.scrollY > cRect.top
       && window.scrollY < cRect.top + cHeight
      ) {
        //if (ice.paused) ice.play();
        if ( ! fixed) {
          fixed = true;
          section.style.position = "fixed";
          section.style.top = 0;
          sectionBelow.style.position = "relative";
          sectionBelow.style.zIndex = 3;
          sectionBelow.style.marginTop = cHeight + "px";
        }
      } else if (fixed) {
        fixed = false;
        section.style.position = "relative";
        section.style.top = "none";
        sectionBelow.style.marginTop = 0;
      }
    });
});

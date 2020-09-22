INSERT INTO task (task_name, task_worker, project_id_fk)
        VALUES
        ('front-end',
        'Demetria',
        (SELECT project_id_pk FROM project WHERE project_id_pk = 1)),

        ('back-end',
        'Paulo',
        (SELECT project_id_pk FROM project WHERE project_id_pk = 2)),

        ('dev-ops',
        'Paulo',
        (SELECT project_id_pk FROM project WHERE project_id_pk = 2));
